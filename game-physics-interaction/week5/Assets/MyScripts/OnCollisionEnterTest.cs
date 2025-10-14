using UnityEngine;

public class OnCollisionEntertest : MonoBehaviour
{

    private void OnCollisionEnter(Collision coll)
    {
        {
            GetComponent<AudioSource>().Play();
        }
    }
}