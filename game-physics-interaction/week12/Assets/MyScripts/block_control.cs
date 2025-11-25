using UnityEngine;

public class block_control : MonoBehaviour
{
    public map_creator map_script = null;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        map_script = GameObject.Find("block_root").GetComponent<map_creator>();
    }

    // Update is called once per frame
    void Update()
    {
        if(map_script.IsGone(gameObject))
        {
            GameObject.Destroy(gameObject);
        }
    }
}
