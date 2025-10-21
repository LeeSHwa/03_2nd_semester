using UnityEngine;

public class parentTest : MonoBehaviour
{

    private GameObject game_object;
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        game_object = GameObject.Find("Cube") as GameObject;
    }

    // Update is called once per frame
    void Update()
    {

        if (Input.GetKey(KeyCode.UpArrow))
            this.transform.Translate(Vector3.forward * 3.0f * Time.deltaTime);
        if (Input.GetKey(KeyCode.DownArrow))
            this.transform.Translate(Vector3.back * 3.0f * Time.deltaTime);

        if (Input.GetKey(KeyCode.P))
        {
            game_object.transform.parent = this.transform;
        }

        if (Input.GetKey(KeyCode.N))
        {
            game_object.transform.parent = null;
        }

    }
}