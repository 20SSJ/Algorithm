#include <iostream>
using namespace std;

int main() {
    int a = 2, b = 5;
    int tmp = a;
    a = b;
    b = tmp;
    cout << a << "\n" << b;
    return 0;
}