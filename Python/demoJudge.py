import subprocess
import random

def evaluate_solution(path, test_cases):
    """
    评测机
    :param path: 代码路径
    :param test_cases: 测试集
    :return:
    """

    for i, (x, expected_y) in enumerate(test_cases):
        try:
            result = subprocess.run(
                path,
                input=str(x)+"\n",
                text=True,
                capture_output=True,
                timeout=2
            )

            output = result.stdout.strip()
            if result.returncode != 0:
                print(f"Test case {i + 1} failed: Runtime error")
                print(result.stderr)
                continue

            if output == str(expected_y):
                print(f"Test case {i + 1} passed")
            else:
                print(f"Test case {i + 1} failed: {output}, expected {expected_y}, x: {x}")
        except subprocess.TimeoutExpired:
            print(f"Test case {i + 1} timed out")
        except Exception as e:
            print(f"Test case {i + 1} failed: {e}")

def calculate_y(x):
    """
    Calculate the smallest y that maximizes the remainder of x * y % 2024.

    :param x: Positive integer (0 < x < 2024)
    :return: Smallest positive integer y that satisfies the condition
    """
    max_remainder = -1
    best_y = None

    for y in range(1, 2024):  # y must be a positive integer
        remainder = (x * y) % 2024
        if remainder > max_remainder:
            max_remainder = remainder
            best_y = y

    return best_y

def generate_test_cases(num_cases):
    """
    Generate test cases for the problem.

    :param num_cases: Number of test cases to generate
    :return: List of test cases as tuples (x, y)
    """
    test_cases = []
    for _ in range(num_cases):
        x = random.randint(1, 2023)  # x is in the range 1 to 2023
        y = calculate_y(x)
        test_cases.append((x, y))
    return test_cases

test_case = generate_test_cases(100)

evaluate_solution(path=["python", "demo.py"], test_cases=test_case)