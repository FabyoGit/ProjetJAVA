/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Onglet1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author stag
 */

// Creation d'une interface fonctionnelle pour manipuler le contexte graphique
public interface ManipulationCont
{
    public void configure(MouseEvent m, GraphicsContext ctx);
}
