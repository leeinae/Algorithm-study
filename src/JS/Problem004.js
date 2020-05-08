// LU
let animals =['척추동물', '어류', '척추동물', '무척추동물', '파충류', '척추동물', '어류', '파충류'];

function solution(animals, chair) {
    let chairs = [];
    let result = 0;

    for (var i of animals) {
        if( chairs.length < chair ) {
            if(chairs.includes(i)) {
                //hit
                chairs.splice(chairs.indexOf(i), 1);
                chairs.push(i);
                result += 1;
            } else {
                //no hit
                chairs.push(i);
                result += 60;
            }
        } else {
            if(chairs.includes(i)) {
                //hit
                chairs.splice(chairs.indexOf(i), 1);
                chairs.push(i);
                result += 1;
            } else {
                //no hit
                chairs.shift();
                chairs.push(i);
                result += 60;
            }
        }
        console.log(chairs);
    }

    return `${parseInt(result/60)}분 ${parseInt(result%60)}초`;
}

console.log(solution(animals, 3));