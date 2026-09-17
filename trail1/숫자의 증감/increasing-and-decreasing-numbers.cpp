#include <iostream>
using namespace std;

int main() {
    char C;
    int N;
    cin >> C >> N;
    if(C == 'A'){
        int i = 1;
        while(i <= N){
            cout << i++ << " ";
        }
    }else{
        while(N > 0){
            cout << N-- << " ";
        }
    }
    return 0;
}