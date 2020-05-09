//0부터 num까지 1의 개수 출력
function solution(num) {
    let str = '';

    for (var i=0; i<num; i++) {
        str += i;
    }

    let count = 0;
    for (let k of str) {
        if(k==1) {
            count++;
        }
    }

    return count;
}

function solution2(num) {
    let str = '';

    for (var i=0; i<num; i++) {
        str += i;
    }

    return str.match(/1/g).length;
}

console.log(solution(15));
console.log(solution2(15));