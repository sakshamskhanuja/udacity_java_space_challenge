public interface Spaceship {

    /**
     * Checks if the rocket has successfully launched.
     *
     * @return true, if the launch was successful, otherwise false.
     */
    boolean launch();

    /**
     * Checks if the rocket has successfully landed.
     *
     * @return true, if the landing was successful, otherwise false.
     */
    boolean land();

    /**
     * Checks if the rocket can carry an {@link Item}.
     *
     * @param item Item to be carried.
     * @return true, if the rocket can carry the {@link Item}, otherwise false.
     */
    boolean canCarry(Item item);

    /**
     * Adds the {@link Item} in the rocket.
     *
     * @param item Item to be carried.
     */
    void carry(Item item);
}
