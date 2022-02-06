package com.senla.daoservice.controller;

import depinject.DepInjReflectUtil;
import depinject.DependencyInjection;

public class ActionController {
    @DependencyInjection
    private IAdminController adminController;

    public IAdminController getAdminController() {
        return adminController;
    }

    public ActionController() {
        DepInjReflectUtil.initializeDepInjection(this);
    }
}
