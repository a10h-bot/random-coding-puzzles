
    select rate_code iflex_rate_code, rate rate_qty
    from ICTM_RATES t
    where eff_dt=(select max(eff_dt)
        from ICTM_RATES s
        where auth_stat='A' and record_stat='O' and t.RATE_CODE=s.RATE_CODE and eff_dt=(select max(today)
            from sttms_dates )) and t.RATE_CODE NOT IN ('CCSPR1','CCSPR2','CCCOMP','CCFFE','CCFFE2','CCSPR3','CCSPR4')
union
    select rate_code iflex_rate_code, rate rate_qty
    from ICTM_RATES t
    where eff_dt=(select max(eff_dt)
        from ICTM_RATES s
        where auth_stat='A' and record_stat='O' and t.RATE_CODE=s.RATE_CODE and eff_dt=(select max(prev_working_day)
            from sttms_dates )) and t.RATE_CODE IN ('CCSPR1','CCSPR2','CCCOMP','CCFFE','CCFFE2','CCSPR3','CCSPR4')




            