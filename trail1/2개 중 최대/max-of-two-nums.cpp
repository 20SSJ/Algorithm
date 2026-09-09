#include <iostream>
using namespace std;

int main() {
    int A, B;
    cin >> A >> B;
    int mx = (A>B) ? A : B;
    cout << mx;
    return 0;
}