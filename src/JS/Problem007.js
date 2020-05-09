let cross =[]; 

let arr = new Array(5).fill(0).map(() => Array(5).fill(0));

console.log(arr);

for (var i = 0; i< c.length; i++) {
    for(var j =0; j<5; j++) {
        if( i==0 && j==0) {
            arr[i][j] = c[i][j];
        } else if(i==0) {
            arr[i][j] = c[i][j] + arr[i][j-1];
        } else if(j==0) {
            arr[i][j] = c[i][j] + arr[i-1][j];
        } else {
            arr[i][j] = Math.min(arr[i][j-1], arr[i-1][j]) + c[i][j];
        }
    }
}

console.log(arr);

let pointArr = new Array(5).fill(0).map(() => Array(5).fill(0).map(() => Array(2).fill(0)));

for (var i = 0; i< c.length; i++) {
    for(var j =0; j<5; j++) {
        if( i==0 && j==0) {
            arr[i][j] = c[i][j];
            pointArr[0][0][0] = i;
            pointArr[0][0][1] = j;
        } else if(i==0) {
            arr[i][j] = c[i][j] + arr[i][j-1];
            pointArr[0][0][0] = i;
            pointArr[0][0][1] = j-1;
        } else if(j==0) {
            arr[i][j] = c[i][j] + arr[i-1][j];
            pointArr[0][0][0] = i-1;
            pointArr[0][0][1] = j;
        } else {
            arr[i][j] = Math.min(arr[i][j-1], arr[i-1][j]) + c[i][j];
            pointArr[0][0][0] = i-1;
            pointArr[0][0][1] = j;
        }
    }
}
console.log(pointArr);