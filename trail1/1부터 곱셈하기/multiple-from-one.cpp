#include <iostream>
using namespace std;

int main() {
    int N, res = 1;
    cin >> N;
    for(int i = 1; i <= 10; i++){
        res *= i;
        if(res >= N){
            cout << i;
            break;
        }
    }
    return 0;
}