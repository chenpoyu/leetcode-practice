#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
MAC_JAVA_21_HOME="/Library/Java/JavaVirtualMachines/zulu-21.jdk"

is_javac_21() {
    [[ "$("$1" -version 2>&1)" == javac\ 21* ]]
}

if [[ -n "${LEETCODE_JAVA_HOME:-}" && -x "$LEETCODE_JAVA_HOME/bin/javac" ]]; then
    JAVAC="$LEETCODE_JAVA_HOME/bin/javac"
    JAVA="$LEETCODE_JAVA_HOME/bin/java"
elif [[ -n "${JAVA_HOME:-}" && -x "$JAVA_HOME/bin/javac" ]] && is_javac_21 "$JAVA_HOME/bin/javac"; then
    JAVAC="$JAVA_HOME/bin/javac"
    JAVA="$JAVA_HOME/bin/java"
elif [[ -x "$MAC_JAVA_21_HOME/bin/javac" ]]; then
    JAVAC="$MAC_JAVA_21_HOME/bin/javac"
    JAVA="$MAC_JAVA_21_HOME/bin/java"
else
    JAVAC="$(command -v javac || true)"
    JAVA="$(command -v java || true)"
fi

if [[ -z "${JAVAC:-}" || -z "${JAVA:-}" ]]; then
    echo "Java 21 is required. Set JAVA_HOME first." >&2
    exit 1
fi

VERSION="$("$JAVAC" -version 2>&1)"
if [[ "$VERSION" != javac\ 21* ]]; then
    echo "Java 21 is required, but found: $VERSION" >&2
    echo "Try: export JAVA_HOME=$MAC_JAVA_21_HOME" >&2
    exit 1
fi

mkdir -p "$ROOT/target/classes" "$ROOT/target"
find "$ROOT/src/main/java" -name '*.java' | sort > "$ROOT/target/sources.txt"

"$JAVAC" --release 21 -encoding UTF-8 -d "$ROOT/target/classes" @"$ROOT/target/sources.txt"
"$JAVA" -cp "$ROOT/target/classes" dev.poyuchen.leetcode.PracticeRunner
