using UnityEngine;

public class destory_cube : MonoBehaviour
{
    GameObject game_object = null;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            game_object = GameObject.Find("Wall") as GameObject;
            Destroy(game_object);
        }
    }
}
