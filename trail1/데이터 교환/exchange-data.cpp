#include <iostream>
using namespace std;

int main() {
    int a = 5, b = 6, c = 7;
    int tmp = a;
    a = c;
    c = b;
    b = tmp;
    cout << a << "\n" << b << "\n" << c;
    return 0;
}