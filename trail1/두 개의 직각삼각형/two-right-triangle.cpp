#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < 2; j++){
            for(int k = 0; k < N - i; k++) cout << "*";
            for(int m = 0; m < 2 * i; m++) cout << " ";
        } cout << "\n";
    }
    return 0;
}