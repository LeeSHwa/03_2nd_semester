using JetBrains.Annotations;
using UnityEngine;

public class ObjectTransform : MonoBehaviour
{
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        // When the 'A' key is pressed, add a random value in the range of -0.2 to 0.2 to the Vector3.
        if (Input.GetKeyDown(KeyCode.A))
        {
            float rnd = Random.Range(-0.2f, 0.2f);
            // 'this' refers to this specific instance of the script component. 
            this.transform.position += new Vector3(rnd, rnd, rnd);
            //Debug.Log(transform.position);
        }

        if (Input.GetKeyDown(KeyCode.B))
        {
            float rnd = Random.Range(0.0f, 360.0f);
            this.transform.rotation = Quaternion.Euler(rnd, 0.0f, 0.0f);
        }

        if (Input.GetKeyDown(KeyCode.C))
        {
            float rnd = Random.Range(0.5f, 1.5f);
            this.transform.localScale = new Vector3(rnd, rnd, rnd);
        }
        // deltaTime is the time in seconds it took to complete the last frame  
        if (Input.GetKey(KeyCode.UpArrow))
        {
            this.transform.Translate(new Vector3(0.0f, 0.0f, 3.0f) * Time.deltaTime);
        }

        if (Input.GetKey(KeyCode.R))
        {
            this.transform.Rotate(90.0f * Time.deltaTime, 0.0f, 0.0f);
        }
    }
}
