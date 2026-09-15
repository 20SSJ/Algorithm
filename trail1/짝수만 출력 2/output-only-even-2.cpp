#include <iostream>
using namespace std;

int main() {
    int A, B;
    cin >> B >> A;
    while(B >= A){
        if(B % 2 == 0){
            cout << B << " ";
            B-=2;
        }
    }
    return 0;
}