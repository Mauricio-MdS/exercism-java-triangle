class Triangle {

    private final double sideOne;
    private final double sideTwo;
    private final double sideThree;

    Triangle(double sideOne, double sideTwo, double sideThree) throws TriangleException {
        validate(sideOne, sideTwo, sideThree);

        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    boolean isEquilateral() {
        return sideOne == sideTwo && sideOne == sideThree;
    }

    boolean isIsosceles() {
        return !isScalene();
    }

    boolean isScalene() {
        return sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree;
    }

    private static void validate(double sideOne, double sideTwo, double sideThree) throws TriangleException {
        var hasZeroSides = sideOne == 0 || sideTwo == 0 || sideThree == 0;
        var oneSideBiggerThanSumOfOtherTwo =
                sideOne + sideTwo < sideThree || sideOne + sideThree < sideTwo || sideTwo + sideThree < sideOne;

        if (hasZeroSides || oneSideBiggerThanSumOfOtherTwo) throw new TriangleException();
    }
}
