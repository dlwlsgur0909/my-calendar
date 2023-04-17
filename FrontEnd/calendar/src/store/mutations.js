export default {

    SET_CALENDAR(state, obj) {

        state.calendar = [];

        const beforeArr = [];

        // 월의 첫날이 일요일인지 확인
        if(obj.currentObj.isFirstZero) {

            for(let i=0; i<7; i++) {

                const data = {
                    year: '',
                    month: '',
                    date: '',
                    isCurrent: '',
                };

                data.year = obj.currentObj.currentYear,
                data.month = obj.currentObj.currentMonth,
                data.date = obj.currentObj.firstDate;
                data.isCurrent = true;

                beforeArr.push(data);
                obj.currentObj.firstDate++;
            }

        }else {
            for(let i=0; i<7; i++) {

                const data = {
                    year: '',
                    month: '',
                    date: '',
                    isCurrent: '',
                };

                if(obj.beforeObj.beforeStart <= obj.beforeObj.beforeEnd) {

                    data.year = obj.beforeObj.beforeYear;
                    data.month = obj.beforeObj.beforeMonth;
                    data.date = obj.beforeObj.beforeStart;
                    data.isCurrent = false;

                    obj.beforeObj.beforeStart++;
                }else {

                    data.year = obj.currentObj.currentYear,
                    data.month = obj.currentObj.currentMonth,
                    data.date = obj.currentObj.firstDate;
                    data.isCurrent = true;

                    obj.currentObj.firstDate++;
                }
                beforeArr.push(data);

            }
        }
        

        state.calendar.push(beforeArr);

        for(let i=1; i<6; i++) {
            
            const dataArr = [];

            for(let j=0; j<7; j++) {

                const data = {
                    year: '',
                    month: '',
                    date: '',
                    isCurrent: ''
                };

                if(obj.currentObj.firstDate <= obj.currentObj.lastDate) {
                    data.year = obj.currentObj.currentYear,
                    data.month = obj.currentObj.currentMonth,
                    data.date = obj.currentObj.firstDate
                    data.isCurrent = true;
                    obj.currentObj.firstDate++;
                }else {
                    if(obj.afterObj.afterStart <= obj.afterObj.afterEnd) {
                        data.year = obj.afterObj.afterYear;
                        data.month = obj.afterObj.afterMonth;
                        data.date = obj.afterObj.afterStart;
                        data.isCurrent = false;
                        obj.afterObj.afterStart++;
                    }
                }
                dataArr.push(data);
            }
            state.calendar.push(dataArr);
        }
    },

    SET_MONTH(state, month) {
        state.month = month;
    },

    SET_YEAR(state, year) {
        state.year = year;
    },

    SET_SCHEDULE(state, data) {
        state.schedule = data;
    },

    SET_SCHEDULE_DETAIL(state, data) {
        state.scheduleDetail = data;
    },


}