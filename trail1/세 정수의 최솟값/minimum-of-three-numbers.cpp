#include <iostream>
using namespace std;

int main() {
    int a, b, c, mn;
    cin >> a >> b >> c;
    mn = a;
    if(mn > b) mn = b;
    if(mn > c) mn = c;
    cout << mn;
    return 0;
}