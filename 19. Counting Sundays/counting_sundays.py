import time
import datetime as dt


class Calendar1:
    def __init__(self, date1, date2):
        self.d1 = dt.date(*[int(i) for i in date1.split('-')])
        self.d2 = dt.date(*[int(i) for i in date2.split('-')])
    
    def _get_next_month(self, date):
        cur_mth = date.month
        cur_yr = (date.year) + cur_mth//12
        cur_mth = (cur_mth ) % 12  + 1
        return dt.date(cur_yr, cur_mth, date.day)

    def solve(self):
        count = 0
        while self.d1 <= self.d2:
            if self.d1.weekday() == 6:
                count += 1
            self.d1 = self._get_next_month(self.d1)
        return count



class Calendar2:
    def __init__(self, start_date, end_date):
        self.date = self._to_dt('1900-01-01')
        self.date1 = self._to_dt(start_date)
        self.date2 = self._to_dt(end_date)
        self.count = 0
        self.days_diff = 0
    
    def _to_dt(self, date):
        self._format = '%Y-%m-%d'
        return dt.datetime.strptime(date, self._format)

    def _calculate_days(self, d):
        return (d - self.date).days
    
    def _check_day(self, d):
        self.days_diff = self._calculate_days(d)
        return (self.days_diff + 1) % 7
    
    def _get_next_month(self, date):
        cur_mth = date.month
        cur_yr = (date.year) + cur_mth//12
        cur_mth = (cur_mth ) % 12  + 1
        return dt.datetime(cur_yr, cur_mth, date.day)

    def solve(self):  
        cur_month = self.date1
        while cur_month < self.date2:
            # print(self.count, cur_month)
            if self._check_day(cur_month) == 0:
                self.count += 1
                # print(self.date1)
            cur_month = self._get_next_month(cur_month)
        return self.count
    


print('Calendar 1 : ', Calendar1('1901-01-01', '2000-12-31').solve())
print('Calendar 2 : ', Calendar2('1901-01-01', '2000-12-31').solve())
