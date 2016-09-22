package edu.orangecoastcollege.cs273.tmorrissey1.inandout;

/**
 * Represents a fast food order
 * Created by Travis on 9/21/2016.
 */
public class Order {

    private final double PRICE_CHEESEBURGER = 2.15;
    private final double PRICE_DOUBLE_DOUBLE = 3.60;
    private final double PRICE_FRENCH_FRIES = 1.65;
    private final double PRICE_LARGE_DRINK = 1.75;
    private final double PRICE_MEDIUM_DRINK = 1.55;
    private final double PRICE_SHAKE = 2.20;
    private final double PRICE_SMALL_DRINK = 1.45;
    private final double TAX_RATE = 0.08;

    /**
     * Number of cheeseburgers on this Order
     */
    private int mCheeseburgers;
    /**
     * Number of double doubles on this Order
     */
    private int mDoubleDoubles;
    /**
     * Number of french fries on this Order
     */
    private int mFrenchFries;
    /**
     * Number of large drinks on this Order
     */
    private int mLargeDrinks;
    /**
     * Number of medium drinks on this Order
     */
    private int mMediumDrinks;
    /**
     * Number of shakes on this Order
     */
    private int mShakes;
    /**
     * Number of small drinks on this Order
     */
    private int mSmallDrinks;

    public Order() {
        mCheeseburgers = mDoubleDoubles = mFrenchFries = mLargeDrinks
                = mSmallDrinks = mMediumDrinks = mSmallDrinks = 0;
    }

    /**
     * Gets number of cheeseburgers on this Order
     * @return number of cheeseburgers
     */
    public int getCheeseburgers() {
        return mCheeseburgers;
    }

    /**
     * Sets number of cheeseburgers on this Order
     * @param cheeseburgers number of cheeseburgers
     */
    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }

    /**
     * Gets number of double doubles on this Order
     * @return number of double doubles
     */
    public int getDoubleDoubles() {
        return mDoubleDoubles;
    }

    /**
     * Sets number of double doubles on this Order
     * @param doubleDoubles number of double doubles
     */
    public void setDoubleDoubles(int doubleDoubles) {
        mDoubleDoubles = doubleDoubles;
    }

    /**
     * Gets number of french fries on this Order
     * @return number of french fries
     */
    public int getFrenchFries() {
        return mFrenchFries;
    }

    /**
     * Sets number of french fries on this order
     * @param frenchFries number of french fries
     */
    public void setFrenchFries(int frenchFries) {
        mFrenchFries = frenchFries;
    }

    /**
     * Gets number of large drinks on this Order
     * @return number of large drinks
     */
    public int getLargeDrinks() {
        return mLargeDrinks;
    }

    /**
     * Sets number of large drinks on this Order
     * @param largeDrinks number of large drinks
     */
    public void setLargeDrinks(int largeDrinks) {
        this.mLargeDrinks = largeDrinks;
    }

    /**
     * Gets number of medium drinks on this Order
     * @return number of medium drinks
     */
    public int getMediumDrinks() {
        return mMediumDrinks;
    }

    /**
     * Sets number of mediuum drinks on this Order
     * @param mediumDrinks number of medium drinks
     */
    public void setMediumDrinks(int mediumDrinks) {
        mMediumDrinks = mediumDrinks;
    }

    /**
     * Gets number of shakes on this Order
     * @return number of shakes
     */
    public int getShakes() {
        return mShakes;
    }

    /**
     * Sets number of shakes on this Order
     * @param shakes number of shakes
     */
    public void setShakes(int shakes) {
        mShakes = shakes;
    }

    /**
     * Gets number of small drinks on this Order
     * @return number of small drinks
     */
    public int getSmallDrinks() {
        return mSmallDrinks;
    }

    /**
     * Sets number of small drinks on this Order
     * @param smallDrinks number of small drinks
     */
    public void setSmallDrinks(int smallDrinks) {
        mSmallDrinks = smallDrinks;
    }

    /**
     * Gets the total number of items on this Order
     * @return total number of items on this order
     */
    public int getNumberItemsOrdered() {
        return mCheeseburgers + mDoubleDoubles + mFrenchFries + mLargeDrinks + mMediumDrinks
                + mShakes + mSmallDrinks;
    }

    /**
     * Calculates the subtotal of this Order
     * @return the subtotal of this Order
     */
    public double calculateSubtotal() {
        return mCheeseburgers * PRICE_CHEESEBURGER + mDoubleDoubles * PRICE_DOUBLE_DOUBLE
                + mFrenchFries * PRICE_FRENCH_FRIES + mLargeDrinks * PRICE_LARGE_DRINK
                + mMediumDrinks * PRICE_MEDIUM_DRINK + mShakes * PRICE_SHAKE
                + mSmallDrinks * PRICE_SMALL_DRINK;
    }

    /**
     * Calculates the Tax of this Order
     * @return the tax
     */
    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    /**
     * Calculates the total of this Order
     * @return the total
     */
    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }
}
