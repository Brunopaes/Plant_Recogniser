package paes.training.c1.relu;

import java.util.Random;

public class ReluTrainingC1 {
    public static void main(String[] args) {
        Random random = new Random(2412);

        int n = 3, minValue = 0, cont = 0, age = 1;
        double sumE = 0, globalError = 0;
        double alpha = 0.0001, eta = 0.45;

        double[][] inputValues = {{0.620, 0.682, 0.203, 0.080}, {0.595, 0.727, 0.188, 0.080},
                {0.582, 0.705, 0.217, 0.080},{0.633, 0.818, 0.203, 0.080},{0.684, 0.886, 0.246, 0.160},
                {0.620, 0.705, 0.217, 0.040},{0.684, 0.841, 0.217, 0.080},{0.608, 0.773, 0.232, 0.080},
                {0.608, 0.682, 0.203, 0.040},{0.544, 0.682, 0.159, 0.040},{0.734, 0.909, 0.174, 0.080},
                {0.684, 0.886, 0.188, 0.160},{0.646, 0.795, 0.203, 0.120},{0.722, 0.864, 0.246, 0.120},
                {0.646, 0.864, 0.217, 0.120},{0.684, 0.773, 0.246, 0.080},{0.582, 0.818, 0.145, 0.080},
                {0.646, 0.750, 0.246, 0.200},{0.608, 0.773, 0.275, 0.080},{0.633, 0.682, 0.232, 0.080},
                {0.658, 0.795, 0.217, 0.080},{0.658, 0.773, 0.203, 0.080},{0.595, 0.727, 0.232, 0.080},
                {0.608, 0.705, 0.232, 0.080},{0.658, 0.932, 0.217, 0.040},{0.696, 0.955, 0.203, 0.080},
                {0.620, 0.705, 0.217, 0.040},{0.633, 0.727, 0.174, 0.080},{0.696, 0.795, 0.188, 0.080},
                {0.620, 0.705, 0.217, 0.040},{0.646, 0.773, 0.217, 0.080},{0.633, 0.795, 0.188, 0.120},
                {0.570, 0.523, 0.188, 0.120},{0.633, 0.795, 0.232, 0.240},{0.646, 0.864, 0.275, 0.160},
                {0.608, 0.682, 0.203, 0.120},{0.646, 0.864, 0.232, 0.080},{0.582, 0.727, 0.203, 0.080},
                {0.671, 0.841, 0.217, 0.080},{0.633, 0.750, 0.203, 0.080},{0.810, 0.727, 0.652, 0.600},
                {0.873, 0.705, 0.710, 0.600},{0.696, 0.523, 0.580, 0.520},{0.823, 0.636, 0.667, 0.600},
                {0.722, 0.636, 0.652, 0.520},{0.620, 0.545, 0.478, 0.400},{0.658, 0.614, 0.565, 0.560},
                {0.633, 0.455, 0.507, 0.400},{0.747, 0.682, 0.609, 0.600},{0.759, 0.500, 0.580, 0.400},
                {0.709, 0.659, 0.522, 0.520},{0.709, 0.682, 0.652, 0.600},{0.734, 0.614, 0.594, 0.400},
                {0.785, 0.500, 0.652, 0.600},{0.709, 0.568, 0.565, 0.440},{0.747, 0.727, 0.696, 0.720},
                {0.772, 0.636, 0.580, 0.520},{0.772, 0.636, 0.681, 0.480},{0.810, 0.659, 0.623, 0.520},
                {0.835, 0.682, 0.638, 0.560},{0.861, 0.636, 0.696, 0.560},{0.848, 0.682, 0.725, 0.680},
                {0.722, 0.591, 0.507, 0.400},{0.696, 0.545, 0.536, 0.400},{0.734, 0.614, 0.565, 0.480},
                {0.759, 0.614, 0.739, 0.640},{0.759, 0.773, 0.652, 0.640},{0.848, 0.705, 0.681, 0.600},
                {0.797, 0.523, 0.638, 0.520},{0.709, 0.682, 0.594, 0.520},{0.696, 0.568, 0.580, 0.520},
                {0.696, 0.591, 0.638, 0.480},{0.772, 0.682, 0.667, 0.560},{0.633, 0.523, 0.478, 0.400},
                {0.709, 0.614, 0.609, 0.520},{0.722, 0.682, 0.609, 0.480},{0.722, 0.659, 0.609, 0.520},
                {0.785, 0.659, 0.623, 0.520},{0.646, 0.568, 0.435, 0.440},{0.722, 0.636, 0.594, 0.520},
                {0.797, 0.750, 0.870, 1.000},{0.734, 0.614, 0.739, 0.760},{0.899, 0.682, 0.855, 0.840},
                {0.823, 0.682, 0.841, 0.880},{0.962, 0.682, 0.957, 0.840},{0.924, 0.659, 0.913, 0.720},
                {0.848, 0.568, 0.841, 0.720},{0.911, 0.818, 0.884, 1.000},{0.823, 0.727, 0.739, 0.800},
                {0.861, 0.682, 0.797, 0.840},{0.722, 0.568, 0.725, 0.800},{0.734, 0.636, 0.739, 0.960},
                {0.823, 0.682, 0.797, 0.720},{0.975, 0.864, 0.971, 0.880},{0.975, 0.591, 1.000, 0.920},
                {0.759, 0.500, 0.725, 0.600},{0.873, 0.727, 0.826, 0.920},{0.709, 0.636, 0.710, 0.800},
                {0.975, 0.636, 0.971, 0.800},{0.911, 0.727, 0.870, 0.720},{0.785, 0.636, 0.696, 0.720},
                {0.772, 0.682, 0.710, 0.720},{0.810, 0.636, 0.812, 0.840},{0.911, 0.682, 0.841, 0.640},
                {0.937, 0.636, 0.884, 0.760},{0.810, 0.636, 0.812, 0.880},{0.797, 0.636, 0.739, 0.600},
                {0.772, 0.591, 0.812, 0.560},{0.975, 0.682, 0.884, 0.920},{0.797, 0.773, 0.812, 0.960},
                {0.810, 0.705, 0.797, 0.720},{0.873, 0.705, 0.783, 0.840},{0.848, 0.705, 0.812, 0.960},
                {0.873, 0.705, 0.739, 0.920},{0.861, 0.727, 0.855, 0.920},{0.848, 0.750, 0.826, 1.000},
                {0.848, 0.682, 0.754, 0.920},{0.797, 0.568, 0.725, 0.760},{0.785, 0.773, 0.783, 0.920},
                {0.747, 0.682, 0.739, 0.720}};

        int[][] desired = {{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},
                {0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},
                {0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},
                {0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},
                {0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 0, 1},{0, 1, 0},{0, 1, 0},{0, 1, 0},
                {0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},
                {0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},
                {0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},
                {0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},{0, 1, 0},
                {0, 1, 0},{0, 1, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},
                {1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},
                {1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},
                {1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},
                {1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0},{1, 0, 0}};

        double[] hli = new double[n];
        double[] hlo = new double[n];

        double[] eli = new double[3];
        double[] elo = new double[3];

        double[][] wl1 = new double[4][n];
        double[][] wl2 = new double[3][n];

        double[] gradientL2 = new double[3];
        double[] gradientL1 = new double[n];

        //Random values for Layer's 1 weights' matrix;
        System.out.println("Layer 1 Weights (Before Training):");
        for (int i = 0; i < wl1.length; i++) {
            for (int j = 0; j < wl1[i].length; j++) {
                wl1[i][j] = random.nextDouble();
                System.out.print(wl1[i][j] + " ");
            }
            System.out.println("");
        }

        //Random values for Layer's 2 weights' matrix;
        System.out.println("\nLayer 2 Weights (Before Training):");
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                wl2[i][j] = random.nextDouble();
                System.out.print(wl2[i][j] + " ");
            }
            System.out.println();
        }

        do {
            sumE = 0;
            for (int i = 0; i < hli.length; i++) {
                hli[i] = 0;
                hlo[i] = 0;
            }

            for (int i = 0; i < eli.length; i++) {
                eli[i] = 0;
                elo[i] = 0;
            }

            if (cont == 120) {
                cont = 0;
                minValue = 0;

                hli = ponderationL1(n, inputValues, minValue, hli, wl1);
                hlo = activationFunctionL1(hlo, hli);

                eli = ponderationL2(eli, wl2, hlo);
                elo = activationFunctionL2(elo, eli);

                globalError = errorCalculation(elo, desired, sumE, cont);

                gradientL2 = gradientCalculationL2(gradientL2, eli, cont, desired, elo);
                gradientL1 = gradientCalculationL1(gradientL1, gradientL2, hlo, wl2, elo);

                wl2 = weightsUpdateL2(wl2, alpha, eta, gradientL2, hlo);
                wl1 = weightsUpdateL1(inputValues, minValue, wl1, alpha, eta, gradientL1);

                age++;
            }

            else {

                hli = ponderationL1(n, inputValues, minValue, hli, wl1);
                hlo = activationFunctionL1(hlo, hli);

                eli = ponderationL2(eli, wl2, hlo);
                elo = activationFunctionL2(elo, eli);

                globalError = errorCalculation(elo, desired, sumE, cont);

                gradientL2 = gradientCalculationL2(gradientL2, eli, cont, desired, elo);
                gradientL1 = gradientCalculationL1(gradientL1, gradientL2, hlo, wl2, elo);

                wl2 = weightsUpdateL2(wl2, alpha, eta, gradientL2, hlo);
                wl1 = weightsUpdateL1(inputValues, minValue, wl1, alpha, eta, gradientL1);

            }
            minValue++;
            cont++;
        } while(globalError > 1E-30);

        System.out.println("\n" + age + " Ages\n");

        System.out.println("Layer 1 Weights (After Training):");
        for (int i = 0; i < wl1.length; i++) {
            for (int j = 0; j < wl1[i].length; j++) {
                System.out.print(wl1[i][j] + ", ");
            }
            System.out.println("");
        }

        System.out.println("\nLayer 2 Weights (After Training):");
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                System.out.print(wl2[i][j] + ", ");
            }
            System.out.println("");
        }
    }

    public static double[] ponderationL1(int n, double[][] inputValues, int minValue, double[] hli, double[][] wl1) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < inputValues[i].length; j++) {
                hli[i] += inputValues[minValue][j] * wl1[j][i];
            }
        }
        return hli;
    }

    public static double[] activationFunctionL1(double[] hlo, double[] hli) {
        for (int i = 0; i < hlo.length; i++) {
            if (hli[i] < 0) hlo[i] = 0;
            else if (hli[i] >= 0) hlo[i] = hli[i];
        }
        return hlo;
    }

    public static double[] ponderationL2(double[] eli, double[][] wl2, double[] hlo) {
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                eli[i] += wl2[i][j] * hlo[j];
            }
        }
        return eli;
    }

    public static double[] activationFunctionL2(double[] elo, double[] eli) {
        for (int i = 0; i < elo.length; i++) {
            if (eli[i] < 0) elo[i] = 0;
            else if (eli[i] >= 0 ) elo[i] = eli[i];
        }
        return elo;
    }

    public static double errorCalculation(double[] elo, int[][] desired, double sumE, int cont) {
        double error = 0;

        for (int i = 0; i < elo.length; i++) {
            sumE += Math.abs(desired[cont][i] - elo[i]);
        }
        return error = sumE/3;
    }

    public static double[] gradientCalculationL2(double[] gradientL2, double[] eli, int cont, int[][] desired, double[] elo) {
        for (int i = 0; i < gradientL2.length; i++) {
            if (elo[i] < 0) gradientL2[i] = 0;
            else if (elo[i] >= 0) gradientL2[i] = 1;
        }
        return  gradientL2;
    }

    public static double[] gradientCalculationL1(double[] gradientL1, double[] gradientL2, double[] hlo, double[][] wl2, double[] elo) {
        for (int i = 0; i < gradientL1.length; i++) {
            if (hlo[i] < 0) gradientL1[i] = 0;
            else if (hlo[i] >= 0) gradientL1[i] = 1;
        }
        return gradientL1;
    }

    public static double[][] weightsUpdateL2(double[][] wl2, double alpha, double eta, double[] gradientL2, double[] hlo) {
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                wl2[i][j] = wl2[i][j] + (alpha * wl2[i][j]) + (eta * gradientL2[i] * hlo[j]);
            }
        }
        return wl2;
    }

    public static double[][] weightsUpdateL1(double[][] inputValues, int minValue, double[][] wl1, double alpha, double eta, double[] gradientL1) {

        double[] aux = new double[4];

        aux[0] = inputValues[minValue][0];
        aux[1] = inputValues[minValue][1];
        aux[2] = inputValues[minValue][2];
        aux[3] = inputValues[minValue][3];

        for (int i = 0; i < wl1.length; i++) {
            for (int j = 0; j < wl1[i].length; j++) {
                wl1[i][j] = wl1[i][j] + (alpha * wl1[i][j]) + (eta * gradientL1[j] * aux[i]);
            }
        }
        return wl1;
    }
}