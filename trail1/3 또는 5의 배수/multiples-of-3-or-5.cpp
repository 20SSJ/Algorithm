#include <iostream>
using namespace std;

int main() {
    int A;
    cin >> A;
    cout << ((A % 3 == 0) ? "YES" : "NO") << "\n" << ((A % 5 == 0) ? "YES" : "NO");
    return 0;
}