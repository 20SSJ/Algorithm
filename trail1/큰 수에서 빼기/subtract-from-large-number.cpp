#include <iostream>
using namespace std;

int main() {
    int A, B;
    cin >> A >> B;
    int answer = (A > B) ? A - B : B - A;
    cout << answer;
    return 0;
}