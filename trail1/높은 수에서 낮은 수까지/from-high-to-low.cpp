#include <iostream>
using namespace std;

int main() {
    int A, B;
    cin >> A >> B;
    if(A > B){
        while(A >= B){
            cout << A-- << " ";
        }
    }else{
        while(B >= A){
            cout << B-- << " ";
        }
    }
    return 0;
}