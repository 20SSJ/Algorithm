#include <iostream>
using namespace std;

int main() {
    int N, a;
    cin >> N >> a;
    int i = 1;
    while(i <= N){
        if(i % a == 0) cout << 1;
        else cout << 0;
        cout << "\n";
        i++;
    }
    return 0;
}