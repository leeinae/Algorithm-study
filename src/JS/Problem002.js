let stone = [5, 3, 4, 1, 3, 8, 3]
let dogs = [{
    "이름" : "루비독",
    "나이" : "95년생",
    "점프력" : "3",
    "몸무게" : "4",
    },{
    "이름" : "피치독",
    "나이" : "95년생",
    "점프력" : "3",
    "몸무게" : "3",
    },{
    "이름" : "씨-독",
    "나이" : "72년생",
    "점프력" : "2",
    "몸무게" : "1",
    },{
    "이름" : "코볼독",
    "나이" : "59년생",
    "점프력" : "1",
    "몸무게" : "1",
    },
]

function run(stone, dogs) {
    let answer = [];
    for(let dog of dogs) {
        let idx = 0;
        let flag = false;
        while(idx < stone.length-1) {
            idx += parseInt(dog['점프력'], 10);
            stone[idx -1] -= parseInt(dog['몸무게'], 10);
            if( stone[idx-1] < 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            answer.push(dog['이름']);
        }
    }
    console.log(answer);
}

run(stone, dogs);