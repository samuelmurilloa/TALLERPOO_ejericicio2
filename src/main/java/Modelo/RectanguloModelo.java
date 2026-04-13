/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author samue
 */

public class RectanguloModelo extends FiguraModelo {

    private PuntoModelo vertice1;
    private PuntoModelo vertice2;

    public RectanguloModelo(PuntoModelo vertice1, PuntoModelo vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
    }

    public PuntoModelo getVertice1() {
        return vertice1;
    }

    public PuntoModelo getVertice2() {
        return vertice2;
    }

    // area (sobreescritura)
    @Override
    public double calcularArea() {
        int base = Math.abs(vertice2.getX() - vertice1.getX());
        int altura = Math.abs(vertice2.getY() - vertice1.getY());
        return base * altura;
    }

    // escalar (solo cambia el segundo punto)
    public void escalar(int nuevoX, int nuevoY) {
        vertice2.setX(nuevoX);
        vertice2.setY(nuevoY);
    }

    // verifica si un punto esta dentro
    public boolean contienePunto(int x, int y) {

        int minX = Math.min(vertice1.getX(), vertice2.getX());
        int maxX = Math.max(vertice1.getX(), vertice2.getX());
        int minY = Math.min(vertice1.getY(), vertice2.getY());
        int maxY = Math.max(vertice1.getY(), vertice2.getY());

        if (x >= minX && x <= maxX) {
            if (y >= minY && y <= maxY) {
                return true;
            }
        }

        return false;
    }

    // mover horizontal
    public void moverHorizontal(int unidades) {
        vertice1.setX(vertice1.getX() + unidades);
        vertice2.setX(vertice2.getX() + unidades);
    }

    // mover vertical
    public void moverVertical(int unidades) {
        vertice1.setY(vertice1.getY() + unidades);
        vertice2.setY(vertice2.getY() + unidades);
    }

    // sobrecarga 1
    public void mover(int dx) {
        moverHorizontal(dx);
    }

    // sobrecarga 2
    public void mover(int dx, int dy) {

        if (dx != 0 && dy == 0) {
            moverHorizontal(dx);
        } else {
            if (dy != 0 && dx == 0) {
                moverVertical(dy);
            }
        }
    }

    @Override
    public String toString() {
        return "Rectangulo: " + vertice1.toString() + " - " + vertice2.toString();
    }
}