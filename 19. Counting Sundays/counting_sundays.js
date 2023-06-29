class Calendar{
    constructor(date1, date2){
        this.date1 = new Date(date1);
        this.date2 = new Date(date2);
        this.count = 0
    }

    // check given year is leap year or not
    isLeapYear(date){
        var year = date.getFullYear();
        if(year%4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return true;
                } else{
                    return false;
                }
            } else{
                return true;
            }
        } else{
            return false;
        }
    }

    getMonthDays(date){
        var feb_days =  date.getFullYear() ? 29 : 28;     
        var days = {1:31, 2:feb_days, 3:31, 5:31, 7:31, 8:31, 10:31, 12:31, 4: 30, 6: 30, 9: 30, 11: 30 }
        // console.log(date.getMonth()+1);
        return days[date.getMonth()+1]; 
    }

    getNextMonth(){
        if(this.date1.getMonth() == 12){
            this.date1.setYear(this.date1.getFullYear()+1);
            this.date1.setMonth(1);            
        } else{
            this.date1.setMonth(this.date1.getMonth()+1);
        }
    }

    calculateDays(){
        var days = 0;
        // console.log(date.getMonth());

        while(this.date1 < this.date2){
            days += this.getMonthDays(this.date1);
            var rem = 0;
            rem = (rem + days)%7;
            if(rem == 0){
                this.count++;
                // console.log(this.date1);
            }
            this.getNextMonth();
        }
        return this.count;
    }
}

var a = new Calendar('1901-01-01', '2000-12-01');
console.log(a.calculateDays());
