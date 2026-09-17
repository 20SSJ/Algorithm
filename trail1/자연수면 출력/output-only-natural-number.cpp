#include <iostream>
using namespace std;

int main() {
    int A, B;
    cin >> A >> B;
    if(A > 0){
        int i = 0;
        while(i < B){
            cout << A;
            i++;
        }
    }else cout << 0;
    return 0;
}