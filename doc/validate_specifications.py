import json
import re
import sys

# Path to the specifications file and the test file
SPEC_FILE = "doc/specifications.json"
TEST_FILE = "src/test/java/com/TDD/tdd/FizzBuzzTest.java"

def load_specifications(spec_file):
    with open(spec_file, 'r') as f:
        specs = json.load(f)
    return specs

def extract_tags_from_specifications(specs):
    tags = set()
    for specification in specs.get("specifications", []):
        for tag in specification.get("tags", []):
            tags.add(tag)
    return tags

def extract_tags_from_test_file(test_file):
    with open(test_file, 'r') as f:
        test_content = f.read()

    # Regex to find @Tag annotations in the test file
    tags = set(re.findall(r'@Tag\(\s*"([^"]+)"\)', test_content))
    return tags

def validate_tags(spec_tags, test_tags):
    missing_tags = spec_tags - test_tags
    return missing_tags

def main():
    # Load specifications from the JSON file
    specs = load_specifications(SPEC_FILE)

    # Extract tags from the specifications and test file
    spec_tags = extract_tags_from_specifications(specs)
    test_tags = extract_tags_from_test_file(TEST_FILE)

    # Validate that all spec tags are present in the test file
    missing_tags = validate_tags(spec_tags, test_tags)

    if missing_tags:
        print("ERROR: Missing tags in the test cases for the following specifications:")
        for tag in missing_tags:
            print(f"- {tag}")
        sys.exit(1)
    else:
        print("All tags are present in the test cases.")
        sys.exit(0)

if __name__ == "__main__":
    main()
