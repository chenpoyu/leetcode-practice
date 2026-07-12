#!/usr/bin/env bash
set -euo pipefail

usage() {
    echo "Usage: $0 <category> <number> <title>"
    echo "Example: $0 arrays 1 two-sum"
}

if [[ $# -lt 3 ]]; then
    usage >&2
    exit 1
fi

CATEGORY_RAW="$1"
NUMBER_RAW="$2"
shift 2
TITLE_RAW="$*"

if [[ ! "$NUMBER_RAW" =~ ^[0-9]+$ ]]; then
    echo "Problem number must be numeric: $NUMBER_RAW" >&2
    exit 1
fi

CATEGORY="$(printf '%s' "$CATEGORY_RAW" | tr '[:upper:]-' '[:lower:]_')"
NUMBER=$((10#$NUMBER_RAW))
printf -v NUMBER_PADDED "%04d" "$NUMBER"

TITLE_PASCAL="$(
    printf '%s\n' "$TITLE_RAW" |
        awk 'BEGIN { FS="[^A-Za-z0-9]+" }
             {
                 for (i = 1; i <= NF; i++) {
                     if ($i == "") {
                         continue
                     }
                     word = tolower($i)
                     printf "%s%s", toupper(substr(word, 1, 1)), substr(word, 2)
                 }
             }'
)"

if [[ -z "$TITLE_PASCAL" ]]; then
    echo "Title must contain letters or numbers." >&2
    exit 1
fi

CLASS_NAME="P${NUMBER_PADDED}${TITLE_PASCAL}"
TARGET_DIR="src/main/java/dev/poyuchen/leetcode/${CATEGORY}"
TARGET_FILE="${TARGET_DIR}/${CLASS_NAME}.java"

if [[ -e "$TARGET_FILE" ]]; then
    echo "File already exists: $TARGET_FILE" >&2
    exit 1
fi

mkdir -p "$TARGET_DIR"

cat > "$TARGET_FILE" <<JAVA
package dev.poyuchen.leetcode.${CATEGORY};

import dev.poyuchen.leetcode.common.Checks;

public final class ${CLASS_NAME} {
    public Object solve() {
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        var solution = new ${CLASS_NAME}();

        Checks.check(solution != null, "${CLASS_NAME} should be created");
        System.out.println("${CLASS_NAME} checks passed.");
    }
}
JAVA

echo "Created $TARGET_FILE"
echo "記得在 PROGRESS.md 補一列，追蹤這題是否完成，以及目前是否最佳解。"
