/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private static int size = 0;

    /**
     * Assigns null value to all elements of the storage
     */
    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    /**
     * Adds new Resume to storage. If Resume with this uuid already exists,
     * displays information about it and does not add an object
     *
     * @param r - Resume to be saved
     */
    void save(Resume r) {
        if (size == 0) {
            storage[size] = r;
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(r.uuid)) {
                    System.out.println("Resume with uuid \"" + r.uuid + "\" is already exist");
                    return;
                }
            }
            storage[size] = r;
            size++;
            return;
        }
    }

    /**
     * Searches for the Resume with passed uuid and returns this Resume if found.
     * If Resume with passed uuid doesn't exist, displays information about it.
     *
     * @param uuid - unique String id
     * @return Resume with uuid equal to the passed parameter
     */
    Resume get(String uuid) {
        Resume targetResume = null;
        if (size == 0) {
            System.out.println("Storage is empty");
        } else {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    targetResume = storage[i];
                    break;
                } else if (i == size - 1) {
                    System.out.println("Uuid " + uuid + " was not found");
                }
            }
        }
        return targetResume;
    }

    /**
     * Deletes Resume with passed uuid from storage and shifts the following elements after deleted by index - 1
     * If Resume with passed uuid doesn't exist, displays information about it and did not make any changes
     *
     * @param uuid - unique String id
     */
    void delete(String uuid) {
        if (size == 0) {
            System.out.println("Storage is empty");
        } else {
            int index = 0;
            for (int i = 0; i < size; i++) {
                index++;
                if (storage[i].uuid.equals(uuid)) {
                    Resume next = storage[index + 1];
                    for (int j = index; j < size; ) {
                        storage[j] = next;
                        j++;
                        next = storage[j + 1];
                    }
                    size--;
                    return;
                }
                if (i == size - 1)
                    System.out.println("Resume with uuid " + uuid + " not found");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes;
        if (size == 0) {
            System.out.println("Storage is empty");
            allResumes = new Resume[0];
        } else {
            allResumes = new Resume[size];
            for (int i = 0; i < size; i++) {
                allResumes[i] = storage[i];
            }
        }
        return allResumes;
    }

    /**
     * @return number of not null storage elements
     */
    int size() {
        return size;
    }
}
