package at.tlaber.model;

/**
 * interface for the Strategy Pattern
 * @author Thomas Laber
 * @version 2024-09-24
 */
public interface StorageSystem {
    public void load(WordTrainer wordTrainer);
    public void store (WordTrainer wordTrainer);
}
