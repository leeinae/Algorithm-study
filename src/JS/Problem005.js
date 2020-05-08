let graph = {100: new Set([67, 66]),
         67: new Set([100, 82, 63]),
         66: new Set([100, 73, 69]),
         82: new Set([67, 61, 79]),
         63: new Set([67]),
         73: new Set([66]),
         69: new Set([66, 65, 81]),
         61: new Set([82]),
         79: new Set([82, 87, 77]),
         65: new Set([69, 84, 99]),
         81: new Set([69]),
         87: new Set([79, 31, 78]),
         77: new Set([79]),
         84: new Set([65]),
         99: new Set([65]),
         31: new Set([87]),
         78: new Set([87])};

function solution(graph, start) {
    let visited = []; 
    let stack = [start];

    while(stack) {
        let n = stack.pop();
        
        if(!visited.includes(n)) {
            visited.push(n);
            let differenceSet = new Set([...graph[n]].filter(x => !(new Set(visited).has(x))));

            for (var v of differenceSet) {
                stack.push(v);
            }
        }

        if(stack.length == 0) {
            break;
        }
    }

    return visited;
}

function solutionMax(graph, start) {
    let visited = []; 
    let stack = [start];

    while(stack) {
        let n = stack.pop();
        
        if(!visited.includes(n)) {
            visited.push(n);
            let differenceSet = new Set([...graph[n]].filter(x => !(new Set(visited).has(x))));


            if([...differenceSet].length == 0) {
                break;
            }

            stack.push(Math.max(...differenceSet));
        }

        if(stack.length == 0) {
            break;
        }
    }

    return visited;
}

function solutionMin(graph, start) {
    let visited = []; 
    let stack = [start];

    while(stack) {
        let n = stack.pop();
        
        if(!visited.includes(n)) {
            visited.push(n);
            let differenceSet = new Set([...graph[n]].filter(x => !(new Set(visited).has(x))));


            if([...differenceSet].length == 0) {
                break;
            }

            stack.push(Math.min(...differenceSet));
        }

        if(stack.length == 0) {
            break;
        }
    }

    return visited;
}

// console.log(solution(graph, 100));
let resultMin = solutionMin(graph, 100); 
let resultMax = solutionMax(graph, 100); 
console.log(resultMin);
console.log(resultMax);

let result = '';
for (var n of resultMin) {
    result += String.fromCharCode(n);
}

console.log(result);

result = '';
for (var n of resultMax) {
    result += String.fromCharCode(n);
}

console.log(result);