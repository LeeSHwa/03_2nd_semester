using System.Collections;
using UnityEngine;

public class spawn : MonoBehaviour
{
    public GameObject pf_wall;
    //public float interval = 1.5f;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    IEnumerator Start()
    {
        while (true)
        {
            Instantiate(pf_wall, transform.position + Vector3.up * Random.Range(-2, 4), transform.rotation);
            yield return new WaitForSeconds(Random.Range(1.0f, 2.0f));
        }
    }

}
