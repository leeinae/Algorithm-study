let waiting = 1200202;

function solution(waiting) {
    let year = 0, month = 0, day = 0, hour = 0, min = 0;
    let people = [25, 40, 55, 70, 85, 100];
    
    dateTaken = waiting / 1200; //걸린 일수
    
    var daysYear =0; //1년 당 일수
    for(var i = 1; i<=10; i++) {
        daysYear += 2**i;
    }

    year = parseInt(dateTaken / daysYear, 10);
    restYear = dateTaken % daysYear;

    for(var i =10; i > 0; i--) {
        month++;
        if( restYear < 2**i) {
            break;
        }
        restYear -= 2**i;
    }

    day = parseInt(restYear, 10);
    month = parseInt(month, 10);
    hour = parseInt((waiting%1200) / 100 + 9, 10);

    for(var idx in people) {
        if(people[idx] > (waiting%1200)%100) {
            min = idx*10; 
            break;
        }
    }

    let date = new Date();
    min += date.getHours();

    if(min > 60) {
        min -= 60;
        hour++;
    } 

    return `
    ${year + date.getFullYear()} 년
    ${month} 월
    ${day} 일
    ${hour} 시
    ${min} 분`
}

console.log(solution(waiting));