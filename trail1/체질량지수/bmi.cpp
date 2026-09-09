#include <iostream>
using namespace std;

int main() {
    int h, w, b;
    cin >> h >> w;
    b = w * 10000/ (h * h);
    cout << b;
    if(b >= 25) cout << "\nObesity";
    return 0;
}