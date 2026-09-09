#include <iostream>
using namespace std;

int main() {
    int A, B;
    cin >> B >> A;
    for(int i  = B; i >= A; i-=2){
        cout << i << " ";
    }
    return 0;
}