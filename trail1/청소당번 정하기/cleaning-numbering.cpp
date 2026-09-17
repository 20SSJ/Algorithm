#include <iostream>
using namespace std;

int main() {
    int n, bath, floor, room;
    bath = floor = room = 0;
    cin >> n;
    for(int i = 1; i <= n; i++){
        if(i % 12 == 0) bath++;
        else if(i % 3 == 0) floor++;
        else if(i % 2 == 0) room++;
    }
    cout << room << " " << floor << " " << bath;
    return 0;
}