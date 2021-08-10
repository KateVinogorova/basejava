/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private static int size = 0;

    void clear() {
        for(int i = 0; i < size; i++){
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (Resume resume : storage) {
            if (resume.uuid.equals(r.uuid)){
                System.out.println("Resume with uuid " + r.uuid + "is already exist");
                return;
            }
            else {
                storage[size] = r;
                size++;
            }
        }
    }

    Resume get(String uuid) {
        Resume targetResume = null;
        for (Resume r : storage) {
            if (r.uuid.equals(uuid)) targetResume = r;
        }
        return targetResume;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResumes;
        if (size == 0) {
            allResumes = null;
            System.out.println("Storage is empty");
        }
        else {
            allResumes = new Resume[size];
            for (int i = 0; i < size; i++) {
                allResumes[i] = storage[i];
            }
            for(Resume r : allResumes) {
                System.out.println(r);
            }
        }
        return allResumes;
    }

    int size() {
        return size;
    }
}
