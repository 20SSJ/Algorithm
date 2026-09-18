#include <iostream>
using namespace std;

int main() {
    int N, num, res = 0;
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> num;
        res += num;
    }
    cout << fixed;
    cout.precision(1);
    cout << res << " " << float(res) / N;
    return 0;
}