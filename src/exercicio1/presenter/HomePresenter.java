/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1.presenter;

import exercicio1.view.HomeView;

/**
 *
 * @author breno
 */
public class HomePresenter {
    private HomeView homeView;
    
    public HomePresenter() {
        this.homeView = new HomeView();
        this.homeView.setVisible(true);
    }
    
}
