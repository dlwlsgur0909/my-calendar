export default {

    SET_CALENDAR(state, obj) {

        state.calendar = [];

        const beforeArr = [];

        if(obj.currentObj.isFirstZero) {
            for(let i=0; i<7; i++) {
                beforeArr.push(obj.currentObj.firstDate);
                obj.currentObj.firstDate++;
            }

        }else {
            for(let i=0; i<7; i++) {
                if(obj.beforeObj.beforeStart <= obj.beforeObj.beforeEnd) {
                    beforeArr.push(obj.beforeObj.beforeStart);
                    obj.beforeObj.beforeStart++;
                }else {
                    beforeArr.push(obj.currentObj.firstDate);
                    obj.currentObj.firstDate++;
                }
            }
        }
        



        state.calendar.push(beforeArr);

        for(let i=1; i<6; i++) {
            
            const dataArr = [];

            for(let j=0; j<7; j++) {
                if(obj.currentObj.firstDate <= obj.currentObj.lastDate) {
                    dataArr.push(obj.currentObj.firstDate);
                    obj.currentObj.firstDate++;
                }else {
                    if(obj.afterObj.afterStart <= obj.afterObj.afterEnd) {
                        dataArr.push(obj.afterObj.afterStart);
                        obj.afterObj.afterStart++;
                    }
                }
            }
            state.calendar.push(dataArr);
        }
    },

    SET_MONTH(state, month) {
        state.month = month;
    },

    SET_YEAR(state, year) {
        state.year = year;
    }


}