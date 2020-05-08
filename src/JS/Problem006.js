let firstMap = [
    [1, 0, 0, 0, 0],
    [0, 0, 1, 0, 1],
    [0, 0, 1, 0, 1],
    [0, 0, 1, 0, 1],
    [0, 0, 1, 0, 1]
];

let secondMap = [
    [0, 0, 0, 0, 1],
    [0, 0, 0, 0, 3],
    [0, 0, 0, 0, 4],
    [0, 2, 0, 0, 2],
    [4, 5, 0, 2, 0]
];

let sample = [];

for(var i=0; i<firstMap.length; i++) {
    sample[i] = new Array(firstMap[0].length);
}

 for (var i=0; i< secondMap.length; i++) {
     for(var j =0; j<secondMap[0].length; j++) {
         sample[i][j] = secondMap[j][secondMap[0].length-1-i];
         sample[i][j] += firstMap[i][j];
     }
 }

for(var v of sample) {
    console.log(String.fromCharCode(parseInt(v.join(''), 8)));
}