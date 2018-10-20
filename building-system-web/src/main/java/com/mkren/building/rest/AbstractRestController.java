package com.mkren.building.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkren.building.service.AvtorizationService;
import com.mkren.building.service.MagazineService;
import com.mkren.building.service.NewRecordService;
import com.mkren.building.service.RedactorService;

public abstract class AbstractRestController {

    @Autowired
    protected AvtorizationService avtorizationService;

    @Autowired
    protected NewRecordService newRecordService;

    @Autowired
    protected MagazineService magazineService;

    @Autowired
    protected RedactorService redactorService;
}