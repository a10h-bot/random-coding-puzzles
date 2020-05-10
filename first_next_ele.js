
function f_next_ele(arr) {
    let i = 0, j = i + 1;
    let n = arr.length;
    let res = [];
    while (i < n) {
        if (arr[i++] < arr[j++]) {
            res.push(arr[j]);
        }
        else if (j < n && j !== n - 1) {
            if (arr[i++] < arr[j++]);
            res.push(arr[j]);
            break;
        }
        else {

        }
    }
    res.push(-1);
    return res;
}

console.log(f_next_ele([3, 1, 9, 7, 2, 8]));
