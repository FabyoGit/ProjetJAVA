/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Onglet1;

/**
 *
 * @author stag
 */

// creation d 'une enumaration Pinceau pour la forme de celui ci et qui renvoie une string 
// qui me servira pour la gestion evenementielle dans l'onglet Dessin
   public enum Pinceau {
		OVALE("Ovale"), RETANGLE("Retangle");

		private final String nom;

		private Pinceau(String nome) {
			this.nom = nome;
		}
                @Override
		public String toString() {
			return nom;
		}

}
