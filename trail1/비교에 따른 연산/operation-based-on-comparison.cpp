#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    int result = (a>b) ? a*b : b / a;
    cout << result;
    return 0;
}